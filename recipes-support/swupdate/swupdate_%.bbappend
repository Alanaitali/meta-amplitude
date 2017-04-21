FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI_append_imx7s-warp += " \
	file://defconfig \
	file://swupdate \
	file://public.pem \
	"

do_install_append() {
    install -d ${D}${datadir}/

    install -m 0644 ${WORKDIR}/public.pem ${D}${datadir}/
}

FILES_${PN} += "${datadir}/*"	
