SUMMARY = "MQTT Client for Qt http://emqtt.io/"
LICENSE = "BSD-3-Clause"
LIC_FILES_CHKSUM = "file://LICENSE;md5=0b04f1c51a1dd83718a9d0fb47d10a29"

SRC_URI = " \
	git://github.com/emqtt/qmqtt;protocol=git \
"

SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

DEPENDS = " qtbase "

INSANE_SKIP_${PN} += "installed-vs-shipped"

inherit qmake5 

do_install_append() {
    find ${D} -name "qmqtt.pc" -delete
}

PACKAGES += "libqmqtt"

FILES_libqmqtt = "${libdir}/libqmqtt.so.1"

