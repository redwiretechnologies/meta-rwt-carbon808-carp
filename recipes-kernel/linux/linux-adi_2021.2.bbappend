FILESEXTRAPATHS:prepend := "${THISDIR}/files:"

SRC_URI += "file://nvme.cfg \
            "


KERNEL_VERSION_SANITY_SKIP="1"
