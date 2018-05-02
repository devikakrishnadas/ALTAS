#!/bin/bash
echo "In enet"
iptables -F
iptables-restore < /home/nandu6177/Desktop/ALTAS/Default.rules
echo "Done enet"

