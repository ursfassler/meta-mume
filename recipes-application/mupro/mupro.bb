SECTION = "app"
DESCRIPTION = "MUME proof of concept fast cgi application"
LICENSE = "GPLv3+"
LIC_FILES_CHKSUM = "file://COPYING;md5=9eef91148a9b14ec7f9df333daebc746"

inherit qmake5

DEPENDS += "fcgi"
RDEPENDS_{PN} += "fcgi"

SRC_URI = " \
	file://COPYING \
	file://mupro.pro \
	file://main.cpp \
	file://FcgiRequest.cpp \
	file://FcgiRequest.hpp \
	file://SysFs.cpp \
	file://SysFs.hpp \
"

S = "${WORKDIR}/"

