# Tables des matières

{% for page in findAll(collectionType = 'wiki', collectionId='wiki') %}
- [{{ page.title }}]({{ page.link }})
{% endfor %}
