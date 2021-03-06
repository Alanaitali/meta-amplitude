SUMMARY = "Qt MQTT Power Meter"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = " \
	git://github.com/Alanaitali/ServiceMQTT;protocol=git \
	file://init-service-mqtt.init \
"

SRCREV = "${AUTOREV}"
S = "${WORKDIR}/git"

DEPENDS = " qtbase"

inherit qmake5 update-rc.d

do_install_append() {
		
        install -d ${D}${sysconfdir}/init.d/
        
        install -m 0755 ${WORKDIR}/init-service-mqtt.init ${D}${sysconfdir}/init.d/init-service-mqtt
}

INITSCRIPT_NAME = "init-service-mqtt"
INITSCRIPT_PARAMS = "start 99 5 2 . stop 19 0 1 6 ."
