define(function (require) {
    var Backbone = require('backbone');

    return Backbone.Model.extend({
        idAttribute: 'fileId',
        urlRoot: 'api/v1/files'
    });
});