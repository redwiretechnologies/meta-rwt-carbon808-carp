DISTRO_FEATURES += "wifi bluetooth"

CORE_IMAGE_EXTRA_INSTALL += "\
    nvme-cli \
    bitfiles-default-carp \
    bitfiles-default-chan-carp \
    bitfiles-dual-carp \
    bitfiles-dual-chan-carp \
    bitfiles-gr-iio-carp \
    misc-gether-files \
    usbc-helper \
    rngd-reboot \
    pciutils \
    dtc \
    python3-setuptools \
    python3-pyadi-iio \
    python3-pybind11 \
    gr-ieee80211 \
    gr-foo \
    gr-adsb \
    python3-colorama \
    gr-mesa \
    python3-bokeh \
    gr-satellites \
    python3-pybind11 \
    python3-typing-extensions \
    nodejs \
    python3-construct \
    python3-matplotlib \
    pciutils \
    python3-pyadi-iio \
    dtc \
    gr-carbon \
    iw \
    bluez5 \
    packagegroup-tools-bluetooth \
"
