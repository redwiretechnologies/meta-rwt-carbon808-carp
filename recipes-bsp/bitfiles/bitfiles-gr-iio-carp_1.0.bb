SUMMARY = "Bitfiles and device-tree additions for running the gr-iio-carp GnuRadio image."
DESCRIPTION = "Bitfiles and device-tree additions for running gr-iio-carp GnuRadio image."
SECTION = "bsp"

LICENSE = "MIT"
LIC_FILES_CHKSUM = " \
        file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302 \
        "

DTS_FILE = "gr-iio-carp.dts"
PERSONALITY = "gr-iio-carp"

FILESEXTRAPATHS:prepend := "${THISDIR}/bitfiles-gr-iio-carp:"

SRC_URI = " \
    file://9eg/system.xsa \
    file://15eg/system.xsa \
    file://gr-iio-carp.dts \
"

include bitfiles.inc
