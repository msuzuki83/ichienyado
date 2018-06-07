#!/bin/bash

# ----------------------------------------
HOST=develop:9000
# ----------------------------------------

RES=$(curl -Ss http://$HOST/webapp/unit_test/test/case01)
if [ "$RES" != "Passed" ]; then
    exit 1
fi

RES=$(curl -Ss http://$HOST/webapp/unit_test/test/case02)
if [ "$RES" != "Passed" ]; then
    exit 1
fi

RES=$(curl -Ss http://$HOST/webapp/unit_test/test/case03)
if [ "$RES" != "Passed" ]; then
    exit 1
fi

RES=$(curl -Ss http://$HOST/webapp/unit_test/test/case04)
if [ "$RES" != "Passed" ]; then
    exit 1
fi
