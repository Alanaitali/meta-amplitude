DESCRIPTION = "amplitude base packagegroup"
AUTHOR = "Pierre-Jean TEXIER"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=4d92cd373abda3937c2bc47fbc49d690"

inherit packagegroup

RDEPENDS_${PN} = "\
    	gdb  \
    	dnsmasq \
    	hostapd \
    	dbus \
    	sysfsutils \
	hostapd \
	dnsmasq \
	bluez5 \
	resetnet \
	init-ifupdown \
	swupdate \
        swupdate-www \
	canutils \
"
