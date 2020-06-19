Problem:
Create a spring boot project to create:
POST API to create catalogues and Suppliers
GET API which can do a full text search on the catalog based on the supplier ID and return SKU Name
Test Cases - RestAssured
Catalog
SKU Code (Unique)
SKU Name
SKU Description
Brand Name
BrandDescritpion
Supplier ID - Foreign
Key

Supplier
Supplier ID (Unique)
Supplier Name

Notes:

SKU FORMAT: [MAX SIZE: 50 chars]

SUPPLIER - PRODUCT_SHORT_HAND - PRODUCT DESC 1(OPT) - PRODDUCT DESC 2(OPT) - PRODUCT DESC 3(OPT)

Eg:
Supplier Name: More

Product Name: Dairy Milk SILK

Product Desc: 100 Gms

SKU: MORE-DMSILK-100G
