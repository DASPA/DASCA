/*
 * Copyright (c) 2010-2015 SAP SE.
 *               2016-2018 The University of Sheffield.
 * 
 * All rights reserved. This program and the accompanying materials
 * This program and the accompanying materials are made
 * available under the terms of the Eclipse Public License 2.0
 * which is available at https://www.eclipse.org/legal/epl-2.0/
 *
 * SPDX-License-Identifier: EPL-2.0
 */

package com.logicalhacking.dasca.crosslanguage.util

import java.io.File

object FileMappingStore {
  val map = scala.collection.mutable.Map[File, FileMapRecorder]()
}
