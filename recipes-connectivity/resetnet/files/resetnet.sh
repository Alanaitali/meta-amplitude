#!/bin/sh
/usr/bin/diode
while true ; do
	/usr/bin/testbtn

	if [ $? -eq 0 ]; then
		echo "test OK"
 		modprobe bcmdhd
		echo 2 > /sys/module/bcmdhd/parameters/op_mode
		/etc/init.d/networking restart
		/etc/init.d/dnsmasq restart
		/etc/init.d/hostapd restart
		echo heartbeat > /sys/class/leds/warp7\:heartbeat/trigger                            
	fi
done &
