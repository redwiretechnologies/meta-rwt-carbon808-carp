SUMMARY = "Device Trees for BSPs"
DESCRIPTION = "Device Tree generation and packaging for BSP Device Trees."
SECTION = "bsp"

LICENSE = "MIT & GPL-2.0-only"
LIC_FILES_CHKSUM = " \
		file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
		file://${COMMON_LICENSE_DIR}/GPL-2.0-only;md5=801f80980d171dd6425610833a22dbe6 \
		"

inherit devicetree

PROVIDES = "virtual/dtb"

FPGA_MNGR_RECONFIG_ENABLE = "1"
# common zynq include
#SRC_URI:append_zynq = " file://zynq-7000-qspi-dummy.dtsi"

# device tree sources for the various machines
COMPATIBLE_MACHINE = "carbon808"
DTC_FLAGS:append = " -@"

SRC_URI = " \
        file://carbon808-pcw.dtsi \
        file://carbon808.dts \
        file://usb-host.dts \
        file://usb-peripheral.dts \
"
