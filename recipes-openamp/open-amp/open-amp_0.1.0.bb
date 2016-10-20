SUMMARY = "Libopen_amp : Libmetal implements an abstraction layer across user-space Linux, baremetal, and RTOS environments"

HOMEPAGE = "https://github.com/OpenAMP/open-amp/"

SECTION = "libs"

LICENSE = "BSD"
LIC_FILES_CHKSUM = "file://LICENSE;md5=b30cbe0b980e98bfd9759b1e6ba3d107"

SRCREV ?= "0a1167cdabeafb035bc992e5069f463828559f64"
SRC_URI = "git://github.com/OpenAMP/open-amp.git;protocol=https;branch=master"

S = "${WORKDIR}/git"

DEPENDS = "libmetal"

inherit pkgconfig cmake

EXTRA_OECMAKE = " \
	-DLIB_INSTALL_DIR=${libdir} \
	-DLIBEXEC_INSTALL_DIR=${libexecdir} \
	-DMACHINE=${SOC_FAMILY} \
	-DWITH_PROXY=OFF \
	"

# Only builds the library but not the applications
#EXTRA_OECMAKE_append_zynqmp = "-DWITH_APPS=ON"