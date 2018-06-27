#!/bin/bash

# ----------------------------------------
HOST=product:9000
# ----------------------------------------

RES=$(curl -Ss http://$HOST/webapp/test/case01)
if [ "$RES" != "Passed" ]; then
    exit 1
fi

RES=$(curl -Ss http://$HOST/webapp/test/case02)
if [ "$RES" != "Passed" ]; then
    exit 1
fi

RES=$(curl -Ss http://$HOST/webapp/test/case03)
if [ "$RES" != "Passed" ]; then
    exit 1
fi

RES=$(curl -Ss http://$HOST/webapp/test/case04)
if [ "$RES" != "Passed" ]; then
    exit 1
fi
