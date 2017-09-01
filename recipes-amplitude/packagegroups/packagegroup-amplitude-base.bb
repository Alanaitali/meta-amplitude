DESCRIPTION = "amplitude base packagegroup"
AUTHOR = "Alan Aït Ali"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

inherit packagegroup

RDEPENDS_${PN} = "\
	alsa-utils \
	alsa-tools \
    	gdb  \
    	dnsmasq \
    	hostapd \
    	dbus \
    	sysfsutils \
	hostapd \
	mosquitto \
    	mosquitto-clients \
    	libmosquitto1 \
	libmosquittopp1 \
	dnsmasq \
	bluez5 \
	qmqtt \
	resetnet \
	init-ifupdown \
	resetnet \
	swupdate \
        swupdate-www \
	canutils \
	gdbserver \
	service-mqtt \
	service-file \
"
