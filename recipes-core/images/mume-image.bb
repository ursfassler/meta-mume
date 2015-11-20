LICENSE = "MIT"

inherit core-image

IMAGE_INSTALL = " \
  packagegroup-core-boot \
  packagegroup-core-ssh-openssh \
  packagegroup-mume-common \
  \
  mumesrv-start \
  mumeweb-start \
  mumehtml \
"

IMAGE_FEATURES += " \
  package-management \
"

