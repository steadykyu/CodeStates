FROM httpd:2.4
WORKDIR /usr/local/apache2/htdocs
COPY ./src/main/resources/templates ./ 
COPY ./src/main/resources/static ./
# 배포시 사용하는 conf 파일
# COPY ./httpd.conf /usr/local/apache2/conf/
