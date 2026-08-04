#!/bin/bash

 pkill openvpn
 sleep 2
sudo openvpn --config $1 &
sleep 2
sudo systemctl restart xray

