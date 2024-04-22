inherit deploy

FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

COMPATIBLE_MACHINE = "carbon808"

SRC_URI += " \
        file://carbon808-pcw.dtsi \
        file://carbon808.dts \
        file://usb-host.dts \
        file://usb-peripheral.dts \
        file://Bismuth-2_0-0.dts \
        file://Bismuth-2_0-1.dts \
        file://Bismuth-2_0-2.dts \
        file://Bismuth-2_0-3.dts \
        file://Bismuth-2_0-4.dts \
        file://Selenium-1_0-0.dts \
        file://Selenium-1_0-1.dts \
        file://Selenium-1_0-2.dts \
        file://Selenium-1_0-3.dts \
        file://Selenium-1_0-4.dts \
        file://Tellurium-1_0-0.dts \
        file://Tellurium-1_0-1.dts \
        file://Tellurium-1_0-2.dts \
        file://Tellurium-1_0-3.dts \
        file://Tellurium-1_0-4.dts \
"

FILES:${PN} +=  " /lib/firmware/rwt/*.dtbo "

do_install:append() {
    for DTB_FILE in `ls *.dtbo`; do
        install -Dm 0644 ${B}/${DTB_FILE} ${D}/lib/firmware/rwt/${DTB_FILE}
    done
}

do_deploy:append() {
    install -Dm 0633 ${B}/carbon808.dtb ${DEPLOYDIR}/carbon808.dtb
    for DTB_FILE in `ls *.dtbo`; do
      install -Dm 0633 ${B}/${DTB_FILE} ${DEPLOYDIR}/lib/firmware/rwt/${DTB_FILE}
    done
}
