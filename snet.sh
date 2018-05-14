#!/bin/bash
echo "In snet"
iptables -F
iptables-restore < /home/nandu6177/Desktop/ALTAS/firewallConfig.rules
echo "Done snet"

