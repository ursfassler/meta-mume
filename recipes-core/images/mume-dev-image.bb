LICENSE = "MIT"

inherit core-image
inherit populate_sdk_qt5

IMAGE_INSTALL = " \
  packagegroup-core-boot \
  packagegroup-core-ssh-openssh \
  \
  kernel-image \
  kernel-devicetree \
  \
  bash \
  binutils \
  bzip2 \
  cppunit \
  devmem2 \
  e2fsprogs \
  e2fsprogs-mke2fs \
  ethtool \
  evtest \
  fcgi \
  file \
  gdb \
  gdbserver \
  gmock \
  gtest \
  htop \
  i2c-tools \
  iputils \
  libtinyxml \
  libudev \
  mtd-utils \
  nginx \
  openssh-sftp \
  openssh-sftp-server \
  perf \
  procps \
  qtbase \
  qtbase-fonts \
  qtbase-plugins \
  qtbase-tools \
  qtsvg \
  qttools \
  qtxmlpatterns \
  screen \
  spawn-fcgi \
  strace \
  sysstat \
  tar \
  tcpdump \
  time \
  usbutils \
  wget \
"

IMAGE_FEATURES += " \
  package-management \
  debug-tweaks \
"

#IMAGE_BOOTLOADER = "u-boot"

