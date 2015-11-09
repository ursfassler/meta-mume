SUMMARY = "common MUME packages"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS_${PN} = "\
  kernel-image \
  kernel-devicetree \
"

