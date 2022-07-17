#!/bin/bash -xe
set -e
cd packer
packer build -force -machine-readable .