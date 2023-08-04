# Указываем базовый образ с Java и Tomcat
FROM tomcat:latest

# Копируем файл сборки в контейнер
COPY target/Servlets.war /usr/local/tomcat/webapps/

# Указываем переменные среды для Tomcat
ENV TZ=UTC
ENV JAVA_OPTS="-Duser.timezone=UTC"

# Открываем порт, на котором будет работать Tomcat
EXPOSE 8080

# Запускаем Tomcat при старте контейнера
CMD ["catalina.sh", "run"]
