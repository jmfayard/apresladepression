package com.eden.orchid.starter;

import com.eden.orchid.api.OrchidContext;
import com.eden.orchid.api.options.annotations.Description;
import com.eden.orchid.api.options.annotations.Option;
import com.eden.orchid.api.theme.components.OrchidComponent;

import javax.inject.Inject;

/**
 * This is an example Component, added as a custom component for this site only. A Component is a block of content that
 * is added to a page in its Front Matter, or to a group of pages through Archetypes.
 *
 * To create a Component, you'll need to:
 *
 * 1) Make a subclass of `OrchidComponent`
 *   - `public class ReplaceComponent extends OrchidComponent`
 *   - `super(context, "replace", 100)`
 * 2) Register that subclass in your custom Module
 *   - in `OrchidStarterModule`: `addToSet(OrchidComponent.class, ReplaceComponent.class)`
 * 3) Create a matching template in `templates/components` to be rendered, whose filename matches the name passed to the superclass constructor
 *   - `templates/components/replace.peb`
 */
@Description(
        name="Replace Component",
        value = "Load a resource by name, and replace usages of `find` with `replace` throughout its contents."
)
public class ReplaceComponent extends OrchidComponent {

    @Option
    @Description("The path to a site resource to load")
    public String resource;

    @Option
    @Description("A String to find within the resource content")
    public String find;

    @Option
    @Description("The replacement String")
    public String replace;

    @Inject
    public ReplaceComponent(OrchidContext context) {
        super(context, "replace", 100);
    }

    public String getContent() {
        return context.getLocalResourceEntry(resource).compileContent(null);
    }

}