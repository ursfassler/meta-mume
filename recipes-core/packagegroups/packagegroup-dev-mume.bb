SUMMARY = "developer tools for MUME"
LICENSE = "MIT"

inherit packagegroup

RDEPENDS_${PN} = "\
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
  vim \
  wget \
"

