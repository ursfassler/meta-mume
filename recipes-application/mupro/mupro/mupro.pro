TEMPLATE = app
CONFIG += console
CONFIG -= app_bundle
CONFIG -= qt

QMAKE_CXXFLAGS += -Wall -Wextra -pedantic -std=c++11

LIBS += -lfcgi -lfcgi++

target.path = /usr/bin
INSTALLS += target

SOURCES += main.cpp \
    FcgiRequest.cpp \
    SysFs.cpp

HEADERS += \
    FcgiRequest.hpp \
    SysFs.hpp

