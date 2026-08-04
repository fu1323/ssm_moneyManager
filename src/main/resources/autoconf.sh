#!/bin/bash
 cmd=$(sed -n "1p" /home/fuchunming/ovpns/config)
 sudo openvpn --config "$(cmd)"