SUMMARY = "Bitfiles and device-tree additions for running the default-carp GnuRadio image."
DESCRIPTION = "Bitfiles and device-tree additions for running default-carp GnuRadio image."
SECTION = "bsp"

LICENSE = "MIT"
LIC_FILES_CHKSUM = " \
        file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
        "

DTS_FILE = "default-carp.dts"
PERSONALITY = "default-carp"

FILESEXTRAPATHS:prepend := "${THISDIR}/bitfiles-default-carp:"

SRC_URI = " \
    file://9eg/system.xsa \
    file://15eg/system.xsa \
    file://default-carp.dts \
"

include bitfiles.inc
