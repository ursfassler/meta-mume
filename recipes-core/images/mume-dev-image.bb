LICENSE = "MIT"

inherit core-image
inherit populate_sdk_qt5

IMAGE_INSTALL = " \
  packagegroup-core-boot \
  packagegroup-core-ssh-openssh \
  packagegroup-mume-common \
  packagegroup-dev-mume \
  \
"

IMAGE_FEATURES += " \
  package-management \
  debug-tweaks \
"

