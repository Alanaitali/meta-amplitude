DESCRIPTION = "WARP7 Resetnet"
LICENSE="GPLv2"
LIC_FILES_CHKSUM = "file://../resetnet.sh;md5=771c6fa8ffdb5a72892f1e165d5dd481"

SRC_URI = " \
        file://resetnet.sh \
        file://testbtn.c \
	file://init \
	"

inherit update-rc.d

do_compile() {
	${CC} ${WORKDIR}/testbtn.c -o testbtn
}

do_install() {
	install -d ${D}${sysconfdir}/init.d
	install -m 755 ${WORKDIR}/init ${D}${sysconfdir}/init.d/resetnet
	install -m 0755 -d ${D}${bindir}
	install -m 0755 ${S}/testbtn ${D}${bindir}/testbtn
	install -m 0755 ${WORKDIR}/resetnet.sh ${D}${bindir}/resetnet
}

FILES_${PN} += "${sysconfdir}"

INITSCRIPT_NAME = "resetnet"
INITSCRIPT_PARAMS = "start 99 5 2 . stop 19 0 1 6 ."
