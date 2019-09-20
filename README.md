[![Netlify Status](https://api.netlify.com/api/v1/badges/99067eaf-6c09-43c5-b088-2239e54f51bb/deploy-status)](https://app.netlify.com/sites/jovial-curie-4a1da4/deploys)

This is a quickstart repo for Orchid to get you up and running as soon as possible. The only system dependency 
necessary to run Orchid is a valid Java 8 JDK and git. 

```bash
git clone https://github.com/JavaEden/OrchidStarter.git
cd OrchidStarter
./gradlew orchidServe

# View your generated site at http://localhost:8080/
```

Alternatively, you can click the button below to automatically clone this repo and deploy it to Netlify. This starter 
repo includes the [Netlify CMS](https://www.netlifycms.org/), so you will be up and publishing content as soon as 
possible. You will need to set the Github user/repo in `src/orchid/resources/config/netlifyCms.yml`, but the rest of the 
CMS config is automatically generated based on your current Orchid plugins and configurations.  

[![Deploy to Netlify](https://www.netlify.com/img/deploy/button.svg)](https://app.netlify.com/start/deploy?repository=https://github.com/JavaEden/OrchidStarter)

### Example Orchid Sites

* [Official Orchid documentation](https://orchid.netlify.com/)
* [caseyjbrooks.com](https://www.caseyjbrooks.com/)
* [pebbletemplates.io](https://pebbletemplates.io/)
* [strikt.io](https://strikt.io/)
* [Krow documentation](https://copper-leaf.github.io/krow/)
* [Trellis documentation](https://copper-leaf.github.io/trellis/)
* [Clog documentation](https://javaeden.github.io/Clog/)
