SUMMARY = "The reference design for carbon808"
DESCRIPTION = "Contains the Reference Design Files and hardware software \
hand-off file. The XSA provides bitstream and Xilinx ps7_init_gpl.c/h \
platform headers."
SECTION = "bsp"

inherit xilinx-platform-init
inherit deploy

DEPENDS += "unzip-native"

LICENSE = "GPL-2.0-only"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6"

COMPATIBLE_MACHINE = "carbon808"

HW_BD = "linux_bd"

S = "${WORKDIR}"

PROVIDES = " \
    virtual/bitstream \
    virtual/xilinx-platform-init \
    virtual/carbon808-boot \
    virtual/hdf"

SYSROOT_DIRS += "${PLATFORM_INIT_DIR}"

FILESEXTRAPATHS:prepend := "${THISDIR}/carbon808-bd:"

SRC_URI = " \
    file://9eg/system.xsa \
    file://15eg/system.xsa \
    file://main.xsa \
    file://fpga-bit-to-bin.py \
    "

MAIN_HDF = "main.xsa"

COMPATIBLE_HOST:xilinx-standalone = "${HOST_SYS}"
PACKAGES = "${PN}-platform-init ${PN}-bitstream"
PACKAGE_ARCH = "${MACHINE_ARCH}"
FILES:${PN}-bitstream += "/boot/*"
FILES:${PN}-platform-init += "${PLATFORM_INIT_DIR}/*"

do_install() {
    all_xsas=${S}/*/system.xsa

    for xsa in ${all_xsas}; do
        bitfile=$(unzip -l ${xsa} | awk '{print $NF}' | grep ".bit$")
        device=$(dirname ${xsa} | xargs -n1 basename)

        unzip -o ${xsa} ${bitfile} -d ${S}/${device}/
        mv ${S}/${device}/${bitfile} ${S}/${device}/download.bit

        install -d ${D}/boot
        ${PYTHON} ${S}/fpga-bit-to-bin.py -f ${S}/${device}/download.bit ${D}/boot/download.${device}.bin
    done

    install -d ${D}${PLATFORM_INIT_DIR}
    for fn in ${PLATFORM_INIT_FILES}; do
        unzip -o ${S}/${MAIN_HDF} ${fn} -d ${D}${PLATFORM_INIT_DIR}
    done
}

do_deploy () {
    install -d ${DEPLOYDIR}
    install -m 0644 ${S}/${MAIN_HDF} ${DEPLOYDIR}/Xilinx-${MACHINE}.xsa

    install -m 0644 ${D}/boot/download.*.bin ${DEPLOYDIR}/
}

addtask do_deploy after do_install
