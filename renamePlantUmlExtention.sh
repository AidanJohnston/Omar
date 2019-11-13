find . -name "*.puml" -type f -delete;
find . -name "*.plantuml" -exec rename -v 's/\.plantuml$/\.puml/i' {} \;
