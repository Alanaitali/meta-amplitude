#!/bin/sh

while true ; do
	/usr/bin/testbtn

	if [ $? -eq 0 ]; then
		echo "test OK"
 		modprobe bcmdhd
		echo 2 > /sys/module/bcmdhd/parameters/op_mode
		/etc/init.d/networking restart
		/etc/init.d/dnsmasq restart
		/etc/init.d/hostapd restart                               
	fi
done &
	
