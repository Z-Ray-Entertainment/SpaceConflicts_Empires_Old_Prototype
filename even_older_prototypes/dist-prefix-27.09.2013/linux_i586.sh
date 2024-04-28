D1=$(readlink -f "$0")
D2=$(dirname "${D1}")
cd "${D2}"


java -Djava.library.path="./lin32" -jar "./space_conflicts_empires.jar"