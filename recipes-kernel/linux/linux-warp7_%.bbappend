FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI_append_imx7s-warp += " \
	file://defconfig \
	file://0001-add-test.patch \
	file://0001-add-ad52.patch \
	file://0001-add-ads1115.patch \
	file://0001-Add-gpio-exporter.patch \
	"
