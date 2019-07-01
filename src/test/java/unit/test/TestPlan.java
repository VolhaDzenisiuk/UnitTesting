package unit.test;

import org.junit.platform.runner.JUnitPlatform;
import org.junit.platform.suite.api.ExcludeTags;
import org.junit.platform.suite.api.IncludeTags;
import org.junit.platform.suite.api.SelectPackages;
import org.junit.runner.RunWith;

@RunWith(JUnitPlatform.class)
@SelectPackages("unit.test")
@IncludeTags({"json_parser_tests", "cart_tests", "virtual_item_tests", "real_item_tests"})
@ExcludeTags({"disabled_tests"})

public class TestPlan {
}
