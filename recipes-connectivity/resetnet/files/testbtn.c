/*
 * $Id: evtest.c,v 1.23 2005/02/06 13:51:42 vojtech Exp $
 *
 *  Copyright (c) 1999-2000 Vojtech Pavlik
 *
 *  Event device test program
 */

/*
 * This program is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation; either version 2 of the License, or 
 * (at your option) any later version.
 * 
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * You should have received a copy of the GNU General Public License
 * along with this program; if not, write to the Free Software
 * Foundation, Inc., 59 Temple Place, Suite 330, Boston, MA 02111-1307 USA
 * 
 * Should you need to contact me, the author, you can do so either by
 * e-mail - mail your message to <vojtech@ucw.cz>, or by paper mail:
 * Vojtech Pavlik, Simunkova 1594, Prague 8, 182 00 Czech Republic
 */

#include <stdint.h>
#include <stdlib.h>

#include <linux/input.h>

#include <string.h>
#include <fcntl.h>
#include <unistd.h>
#include <stdio.h>

int main (int argc, char **argv)
{
	int fd, rd, i, j, k;
	struct input_event ev[64];
	char name[256] = "/dev/input/event4";
        int initsec = 0;
        int finalsec = 0;
	if ((fd = open(name, O_RDONLY)) < 0) {
		perror("evtest");
		return 1;
	}

	while (1) {
		rd = read(fd, ev, sizeof(struct input_event) * 64);

		if (rd < (int) sizeof(struct input_event)) {
			printf("yyy\n");
			perror("\nevtest: error reading");
			return 1;
		}

                for (i = 0; i < rd / sizeof(struct input_event); i++) {
                        if (ev[i].type == EV_KEY) {
                                if (ev[i].code == KEY_BACK) {
                                        if (ev[i].value == 1) {
                                                initsec = ev[i].time.tv_sec;
                                        }
                                        if (ev[i].value == 0) {
                                                finalsec = ev[i].time.tv_sec;
                                        }
                                        if ((finalsec - initsec) > 1)
                                                exit(0);
                                }
                        }
                }
	}
}
