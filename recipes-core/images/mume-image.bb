LICENSE = "MIT"

inherit core-image

IMAGE_INSTALL = " \
  packagegroup-core-boot \
  packagegroup-core-ssh-openssh \
  packagegroup-mume-common \
  \
  mumesrv-start \
  mumeweb-start \
"

IMAGE_FEATURES += " \
  package-management \
"

