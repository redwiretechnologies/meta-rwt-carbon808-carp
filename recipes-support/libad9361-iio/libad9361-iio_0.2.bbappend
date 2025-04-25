SUMMARY = "Library to manage multi-chip sync on FMCOMMS5 platforms with multiple AD9361 devices"
SECTION = "libs"
LICENSE = "LGPLv2.1+"
LIC_FILES_CHKSUM = "file://LICENSE;md5=40d2542b8c43a3ec2b7f5da31a697b88"
BRANCH = "carpscarthgap"

# If we are in an offline build we cannot use AUTOREV since it would require internet!
SRCREV = "8130d835c2ff455e3068b755c079ea0613fb2889" 
PV:append = "+git${SRCPV}"

SRC_URI = "git://github.com/redwiretechnologies/libad9361-iio.git;protocol=https;branch=${BRANCH}"

S = "${WORKDIR}/git"

DEPENDS += "libgpiod"

