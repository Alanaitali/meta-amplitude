#!/bin/sh

while true; do
	ifconfig | grep wlan > /dev/null

		if [ $? == 0 ]; then
			cat /sys/class/leds/warp7\:heartbeat/trigger | grep '\[heartbeat\]' > /dev/null

			if [ $? == 1 ]; then
				echo heartbeat > /sys/class/leds/warp7\:heartbeat/trigger 
			fi
		else
		echo none > /sys/class/leds/warp7\:heartbeat/trigger
		fi
	sleep 1
done &
