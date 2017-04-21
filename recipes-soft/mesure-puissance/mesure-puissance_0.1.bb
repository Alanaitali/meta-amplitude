SUMMARY = "mesure puissance"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"

SRC_URI = " \
	file://mesure \
"

do_install_append() {
		
        install -d ${D}${bindir}
        
        install -m 0755 ${WORKDIR}/mesure ${D}${bindir}
}

