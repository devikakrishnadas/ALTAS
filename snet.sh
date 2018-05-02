#!/bin/bash
echo "In snet"
iptables-save > /home/nandu6177/Desktop/ALTAS/Default.rules
iptables -F
iptables-restore < /home/nandu6177/Desktop/ALTAS/firewallConfig.rules
echo "Done snet"

