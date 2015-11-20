SECTION = "app"
DESCRIPTION = "MUME D-Bus to web gateway"
LICENSE = "GPLv3+"
LIC_FILES_CHKSUM = "file://COPYING;md5=9eef91148a9b14ec7f9df333daebc746"

inherit qmake5

DEPENDS += " \
  qtbase \
  fcgi \
"

RDEPENDS_${PN} += " \
  mumesrv \
  qtbase \
  dbus \
  fcgi \
"

SRCREV = "c674b5e8e1bd83c123f0abb4f22b1775496997a9"

SRC_URI = " \
	git://github.com/ursfassler/mumeweb.git;protocol=https;branch=master \
"

S = "${WORKDIR}/git"
QMAKE_PROFILES = "${S}/application/application.pro"

