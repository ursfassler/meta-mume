SECTION = "app"
DESCRIPTION = "MUME D-Bus interface to hardware"
LICENSE = "GPLv3+"
LIC_FILES_CHKSUM = "file://COPYING;md5=9eef91148a9b14ec7f9df333daebc746"

inherit qmake5

DEPENDS += "qtbase"
RDEPENDS_{PN} += "qtbase dbus"

SRCREV = "5303ff7d9b69643b834094e5d53e098b294954c2"

SRC_URI = " \
	git://github.com/ursfassler/mumesrv.git;protocol=https;branch=master \
	file://dbus.conf \
"

S = "${WORKDIR}/git"
QMAKE_PROFILES = "${S}/application/application.pro"

do_install_append() {
	install -d ${D}${sysconfdir}/dbus-1/system.d
	install -m 0644 ${WORKDIR}/dbus.conf ${D}${sysconfdir}/dbus-1/system.d/mumesrv.conf
}

