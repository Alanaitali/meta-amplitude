DESCRIPTION = "WARP7 Resetnet"
LICENSE="GPLv2"
LIC_FILES_CHKSUM = "file://../resetnet.sh;md5=cf151841bbedeade702382933f446f9d"

SRC_URI = " \
        file://resetnet.sh \
        file://testbtn.c \
	file://init \
	file://diode.sh \
	"

inherit update-rc.d

do_compile() {
	${CC} ${WORKDIR}/testbtn.c -o testbtn
}

do_install() {
	install -d ${D}${sysconfdir}/init.d
	install -d ${D}${bindir}

	install -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/init-resetnet
	install -m 0755 ${S}/testbtn ${D}${bindir}/testbtn
	install -m 0755 ${WORKDIR}/resetnet.sh ${D}${bindir}/resetnet
	install -m 0755 ${WORKDIR}/diode.sh ${D}${bindir}/diode
}

FILES_${PN} += "${sysconfdir}"

INITSCRIPT_NAME = "init-resetnet"
INITSCRIPT_PARAMS = "start 99 5 2 . stop 19 0 1 6 ."
