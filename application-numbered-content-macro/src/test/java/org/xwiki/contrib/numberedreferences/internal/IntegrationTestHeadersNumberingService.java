/*
 * See the NOTICE file distributed with this work for additional
 * information regarding copyright ownership.
 *
 * This is free software; you can redistribute it and/or modify it
 * under the terms of the GNU Lesser General Public License as
 * published by the Free Software Foundation; either version 2.1 of
 * the License, or (at your option) any later version.
 *
 * This software is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE. See the GNU
 * Lesser General Public License for more details.
 *
 * You should have received a copy of the GNU Lesser General Public
 * License along with this software; if not, write to the Free
 * Software Foundation, Inc., 51 Franklin St, Fifth Floor, Boston, MA
 * 02110-1301 USA, or see the FSF site: http://www.fsf.org.
 */
package org.xwiki.contrib.numberedreferences.internal;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Named;
import javax.inject.Singleton;

import org.xwiki.component.annotation.Component;
import org.xwiki.contrib.numberedreferences.AbstractHeadersNumberingService;
import org.xwiki.rendering.block.Block;
import org.xwiki.rendering.block.HeaderBlock;
import org.xwiki.rendering.block.match.ClassBlockMatcher;

/**
 * Numbering Service used for the integration tests, selects all the headers in the document.
 *
 * @version $Id$
 * @since 1.0
 */
@Component
@Singleton
@Named("integrationtestheaders")
public class IntegrationTestHeadersNumberingService extends AbstractHeadersNumberingService
{
    @Override
    public List<HeaderBlock> getHeaderBlocks(Block rootBlock)
    {
        List<HeaderBlock> list = new ArrayList<>();
        for (Block block : rootBlock.getBlocks(new ClassBlockMatcher(HeaderBlock.class),
            Block.Axes.DESCENDANT)) {
            list.add((HeaderBlock) block);
        }
        return list;
    }
}
