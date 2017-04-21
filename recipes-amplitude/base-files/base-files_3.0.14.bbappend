
FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

SRC_URI += "file://motd \
	    file://fstab \
           "
# Set HOSTNAME
hostname = "amplitude"

