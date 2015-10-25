SECTION = "kernel"
DESCRIPTION = "Mainline Linux kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

PROVIDES="linux"

inherit kernel

require recipes-kernel/linux/linux-dtb.inc
require recipes-kernel/linux/setup-defconfig.inc

# Pull in the devicetree files into the rootfs
RDEPENDS_kernel-base += "kernel-devicetree"

# Add a run-time dependency for the PM firmware to be installed
# on the target file system.
RDEPENDS_kernel-base_append_ti33x = " am33x-cm3"

# Default is to package all dtb files for ti33x devices unless building
# for the specific beaglebone machine.
KERNEL_DEVICETREE_beaglebone = "bonegreen-mume.dtb"

KERNEL_EXTRA_ARGS += "LOADADDR=${UBOOT_ENTRYPOINT}"

DEFAULT_PREFERENCE = "-1"

S = "${WORKDIR}/git"

BRANCH = "linux-4.2.y"

SRCREV = "fcba09f2b0bf27eeaa1d4d439edb649585f35040"
PV = "4.2.3"

SRC_URI = " \
	git://git.kernel.org/pub/scm/linux/kernel/git/stable/linux-stable.git;protocol=git;branch=${BRANCH} \
	file://0001-device-tree-for-beagle-bone-green.patch \
	file://0002-mume-driver.patch \
	file://0003-mume-device.patch \
	file://defconfig \
"

# workaround to select correct device tree, replace with nice solution
do_deploy_append () {
	# get first entry in list
	read -r dtfile otherdts << EOF
	${KERNEL_DEVICETREE}
EOF
# do not indent above line!

	echo "fdtfile=${dtfile}" > ${DEPLOYDIR}/uEnv.txt
}


