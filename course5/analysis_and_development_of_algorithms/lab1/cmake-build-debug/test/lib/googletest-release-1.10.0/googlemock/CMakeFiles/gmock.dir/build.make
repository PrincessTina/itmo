# CMAKE generated file: DO NOT EDIT!
# Generated by "MinGW Makefiles" Generator, CMake Version 3.17

# Delete rule output on recipe failure.
.DELETE_ON_ERROR:


#=============================================================================
# Special targets provided by cmake.

# Disable implicit rules so canonical targets will work.
.SUFFIXES:


# Disable VCS-based implicit rules.
% : %,v


# Disable VCS-based implicit rules.
% : RCS/%


# Disable VCS-based implicit rules.
% : RCS/%,v


# Disable VCS-based implicit rules.
% : SCCS/s.%


# Disable VCS-based implicit rules.
% : s.%


.SUFFIXES: .hpux_make_needs_suffix_list


# Command-line flag to silence nested $(MAKE).
$(VERBOSE)MAKESILENT = -s

# Suppress display of executed commands.
$(VERBOSE).SILENT:


# A target that is always out of date.
cmake_force:

.PHONY : cmake_force

#=============================================================================
# Set environment variables for the build.

SHELL = cmd.exe

# The CMake executable.
CMAKE_COMMAND = "D:\Program Files\JetBrains\CLion 2020.3\bin\cmake\win\bin\cmake.exe"

# The command to remove a file.
RM = "D:\Program Files\JetBrains\CLion 2020.3\bin\cmake\win\bin\cmake.exe" -E rm -f

# Escaping for special characters.
EQUALS = =

# The top-level source directory on which CMake was run.
CMAKE_SOURCE_DIR = "D:\Documents\ITMO University\Github Repository\itmo\course5\analysis_and_development_of_algorithms\lab1"

# The top-level build directory on which CMake was run.
CMAKE_BINARY_DIR = "D:\Documents\ITMO University\Github Repository\itmo\course5\analysis_and_development_of_algorithms\lab1\cmake-build-debug"

# Include any dependencies generated for this target.
include test/lib/googletest-release-1.10.0/googlemock/CMakeFiles/gmock.dir/depend.make

# Include the progress variables for this target.
include test/lib/googletest-release-1.10.0/googlemock/CMakeFiles/gmock.dir/progress.make

# Include the compile flags for this target's objects.
include test/lib/googletest-release-1.10.0/googlemock/CMakeFiles/gmock.dir/flags.make

test/lib/googletest-release-1.10.0/googlemock/CMakeFiles/gmock.dir/src/gmock-all.cc.obj: test/lib/googletest-release-1.10.0/googlemock/CMakeFiles/gmock.dir/flags.make
test/lib/googletest-release-1.10.0/googlemock/CMakeFiles/gmock.dir/src/gmock-all.cc.obj: test/lib/googletest-release-1.10.0/googlemock/CMakeFiles/gmock.dir/includes_CXX.rsp
test/lib/googletest-release-1.10.0/googlemock/CMakeFiles/gmock.dir/src/gmock-all.cc.obj: ../test/lib/googletest-release-1.10.0/googlemock/src/gmock-all.cc
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --progress-dir="D:\Documents\ITMO University\Github Repository\itmo\course5\analysis_and_development_of_algorithms\lab1\cmake-build-debug\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_1) "Building CXX object test/lib/googletest-release-1.10.0/googlemock/CMakeFiles/gmock.dir/src/gmock-all.cc.obj"
	cd /d "D:\Documents\ITMO University\Github Repository\itmo\course5\analysis_and_development_of_algorithms\lab1\cmake-build-debug\test\lib\googletest-release-1.10.0\googlemock" && "D:\Program Files\Mingw-w64\x86_64-8.1.0-posix-seh-rt_v6-rev0\mingw64\bin\g++.exe"  $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -o CMakeFiles\gmock.dir\src\gmock-all.cc.obj -c "D:\Documents\ITMO University\Github Repository\itmo\course5\analysis_and_development_of_algorithms\lab1\test\lib\googletest-release-1.10.0\googlemock\src\gmock-all.cc"

test/lib/googletest-release-1.10.0/googlemock/CMakeFiles/gmock.dir/src/gmock-all.cc.i: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Preprocessing CXX source to CMakeFiles/gmock.dir/src/gmock-all.cc.i"
	cd /d "D:\Documents\ITMO University\Github Repository\itmo\course5\analysis_and_development_of_algorithms\lab1\cmake-build-debug\test\lib\googletest-release-1.10.0\googlemock" && "D:\Program Files\Mingw-w64\x86_64-8.1.0-posix-seh-rt_v6-rev0\mingw64\bin\g++.exe" $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -E "D:\Documents\ITMO University\Github Repository\itmo\course5\analysis_and_development_of_algorithms\lab1\test\lib\googletest-release-1.10.0\googlemock\src\gmock-all.cc" > CMakeFiles\gmock.dir\src\gmock-all.cc.i

test/lib/googletest-release-1.10.0/googlemock/CMakeFiles/gmock.dir/src/gmock-all.cc.s: cmake_force
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green "Compiling CXX source to assembly CMakeFiles/gmock.dir/src/gmock-all.cc.s"
	cd /d "D:\Documents\ITMO University\Github Repository\itmo\course5\analysis_and_development_of_algorithms\lab1\cmake-build-debug\test\lib\googletest-release-1.10.0\googlemock" && "D:\Program Files\Mingw-w64\x86_64-8.1.0-posix-seh-rt_v6-rev0\mingw64\bin\g++.exe" $(CXX_DEFINES) $(CXX_INCLUDES) $(CXX_FLAGS) -S "D:\Documents\ITMO University\Github Repository\itmo\course5\analysis_and_development_of_algorithms\lab1\test\lib\googletest-release-1.10.0\googlemock\src\gmock-all.cc" -o CMakeFiles\gmock.dir\src\gmock-all.cc.s

# Object files for target gmock
gmock_OBJECTS = \
"CMakeFiles/gmock.dir/src/gmock-all.cc.obj"

# External object files for target gmock
gmock_EXTERNAL_OBJECTS =

lib/libgmockd.a: test/lib/googletest-release-1.10.0/googlemock/CMakeFiles/gmock.dir/src/gmock-all.cc.obj
lib/libgmockd.a: test/lib/googletest-release-1.10.0/googlemock/CMakeFiles/gmock.dir/build.make
lib/libgmockd.a: test/lib/googletest-release-1.10.0/googlemock/CMakeFiles/gmock.dir/link.txt
	@$(CMAKE_COMMAND) -E cmake_echo_color --switch=$(COLOR) --green --bold --progress-dir="D:\Documents\ITMO University\Github Repository\itmo\course5\analysis_and_development_of_algorithms\lab1\cmake-build-debug\CMakeFiles" --progress-num=$(CMAKE_PROGRESS_2) "Linking CXX static library ..\..\..\..\lib\libgmockd.a"
	cd /d "D:\Documents\ITMO University\Github Repository\itmo\course5\analysis_and_development_of_algorithms\lab1\cmake-build-debug\test\lib\googletest-release-1.10.0\googlemock" && $(CMAKE_COMMAND) -P CMakeFiles\gmock.dir\cmake_clean_target.cmake
	cd /d "D:\Documents\ITMO University\Github Repository\itmo\course5\analysis_and_development_of_algorithms\lab1\cmake-build-debug\test\lib\googletest-release-1.10.0\googlemock" && $(CMAKE_COMMAND) -E cmake_link_script CMakeFiles\gmock.dir\link.txt --verbose=$(VERBOSE)

# Rule to build all files generated by this target.
test/lib/googletest-release-1.10.0/googlemock/CMakeFiles/gmock.dir/build: lib/libgmockd.a

.PHONY : test/lib/googletest-release-1.10.0/googlemock/CMakeFiles/gmock.dir/build

test/lib/googletest-release-1.10.0/googlemock/CMakeFiles/gmock.dir/clean:
	cd /d "D:\Documents\ITMO University\Github Repository\itmo\course5\analysis_and_development_of_algorithms\lab1\cmake-build-debug\test\lib\googletest-release-1.10.0\googlemock" && $(CMAKE_COMMAND) -P CMakeFiles\gmock.dir\cmake_clean.cmake
.PHONY : test/lib/googletest-release-1.10.0/googlemock/CMakeFiles/gmock.dir/clean

test/lib/googletest-release-1.10.0/googlemock/CMakeFiles/gmock.dir/depend:
	$(CMAKE_COMMAND) -E cmake_depends "MinGW Makefiles" "D:\Documents\ITMO University\Github Repository\itmo\course5\analysis_and_development_of_algorithms\lab1" "D:\Documents\ITMO University\Github Repository\itmo\course5\analysis_and_development_of_algorithms\lab1\test\lib\googletest-release-1.10.0\googlemock" "D:\Documents\ITMO University\Github Repository\itmo\course5\analysis_and_development_of_algorithms\lab1\cmake-build-debug" "D:\Documents\ITMO University\Github Repository\itmo\course5\analysis_and_development_of_algorithms\lab1\cmake-build-debug\test\lib\googletest-release-1.10.0\googlemock" "D:\Documents\ITMO University\Github Repository\itmo\course5\analysis_and_development_of_algorithms\lab1\cmake-build-debug\test\lib\googletest-release-1.10.0\googlemock\CMakeFiles\gmock.dir\DependInfo.cmake" --color=$(COLOR)
.PHONY : test/lib/googletest-release-1.10.0/googlemock/CMakeFiles/gmock.dir/depend

